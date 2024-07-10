/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  vfvla
 * Created: 9 июл. 2024 г.
 */

CREATE TABLE wallet (
    id UUID PRIMARY KEY,
    balance BIGINT NOT NULL
);

CREATE TABLE transaction (
    id UUID PRIMARY KEY,
    wallet_id UUID,
    operation_type VARCHAR(10),
    amount BIGINT,
    CONSTRAINT fk_wallet
        FOREIGN KEY(wallet_id) 
            REFERENCES wallet(id)
);
