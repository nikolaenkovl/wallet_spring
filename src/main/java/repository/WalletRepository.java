/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.UUID;
import model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author vfvla
 */
public interface WalletRepository extends JpaRepository<Wallet, UUID> {}
