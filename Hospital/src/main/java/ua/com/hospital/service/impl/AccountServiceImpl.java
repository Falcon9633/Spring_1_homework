package ua.com.hospital.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.com.hospital.dto.AccountDto;
import ua.com.hospital.exception.AccountDetailsNotFoundException;
import ua.com.hospital.exception.AccountNotFoundException;
import ua.com.hospital.exception.PatientNotFoundException;
import ua.com.hospital.mapper.AccountDtoMapper;
import ua.com.hospital.model.Account;
import ua.com.hospital.model.AccountDetails;
import ua.com.hospital.model.Doctor;
import ua.com.hospital.model.Patient;
import ua.com.hospital.model.enums.Role;
import ua.com.hospital.repository.AccountDetailsRepository;
import ua.com.hospital.repository.AccountRepository;
import ua.com.hospital.repository.DoctorRepository;
import ua.com.hospital.repository.PatientRepository;
import ua.com.hospital.service.AccountService;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountDetailsRepository accountDetailsRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    private final AccountDtoMapper accountDtoMapper;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = accountDtoMapper.mapDtoToAccount(accountDto);
        AccountDetails accountDetails = accountDtoMapper.mapDtoToAccDetails(accountDto);
        Account accountFromDB = accountRepository.save(account);
        accountDetails.setAccount(accountFromDB);
        AccountDetails accDetailsFromDB = accountDetailsRepository.save(accountDetails);

        if (account.getRole() == Role.DOCTOR) {
            Doctor doctor = new Doctor();
            doctor.setAccount(accountFromDB);
            doctorRepository.save(doctor);
        }

        Patient patientFromDB = null;
        if (account.getRole() == Role.PATIENT) {
            Patient patient = accountDtoMapper.mapDtoToPatient(accountDto);
            patient.setAccount(accountFromDB);
            patientFromDB = patientRepository.save(patient);
        }

        return accountDtoMapper.mapAccountAndAccDetailsAndPatientToDto(accountFromDB, accDetailsFromDB, patientFromDB);
    }

    @Override
    public AccountDto getAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(AccountNotFoundException::new);
        AccountDetails accountDetails = accountDetailsRepository.findById(id).orElseThrow(AccountDetailsNotFoundException::new);
        Patient patient = null;
        if (account.getRole() == Role.PATIENT) {
            patient = patientRepository.findById(id).orElseThrow(PatientNotFoundException::new);
        }
        return accountDtoMapper.mapAccountAndAccDetailsAndPatientToDto(account, accountDetails, patient);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accountDtoMapper.mapAccountsToDtos(accounts);
    }


    @Override
    public AccountDto updateAccount(Long id, AccountDto accountDto) {
        return null;
    }
}