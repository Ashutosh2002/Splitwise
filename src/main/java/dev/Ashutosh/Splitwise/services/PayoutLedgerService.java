package dev.Ashutosh.Splitwise.services;

import dev.Ashutosh.Splitwise.models.PayoutLedger;
import dev.Ashutosh.Splitwise.repository.PayoutLedgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayoutLedgerService {

    @Autowired
    private PayoutLedgerRepository payoutLedgerRepository;

    public PayoutLedger createPayoutLedger(PayoutLedger payoutLedger){
        return payoutLedgerRepository.save(payoutLedger);
    }

}
