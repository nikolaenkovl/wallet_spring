/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.UUID;
import model.Transaction;
import model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.TransactionRepository;
import repository.WalletRepository;

/**
 *
 * @author vfvla
 */
@Service
public class WalletService {
    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public void performTransaction(UUID walletId, String operationType, long amount) {
        Wallet wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));

        if ("DEPOSIT".equals(operationType)) {
            wallet.setBalance(wallet.getBalance() + amount);
        } else if ("WITHDRAW".equals(operationType)) {
            if (wallet.getBalance() < amount) {
                throw new RuntimeException("Insufficient funds");
            }
            wallet.setBalance(wallet.getBalance() - amount);
        } else {
            throw new RuntimeException("Invalid operation type");
        }

        Transaction transaction = new Transaction();
        transaction.setId(UUID.randomUUID());
        transaction.setWalletId(walletId);
        transaction.setOperationType(operationType);
        transaction.setAmount(amount);

        walletRepository.save(wallet);
        transactionRepository.save(transaction);
    }

    public long getWalletBalance(UUID walletId) {
        Wallet wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));
        return wallet.getBalance();
    }
}
