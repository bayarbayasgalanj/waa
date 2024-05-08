import React, { useState, useEffect } from 'react';
import axios from 'axios';

export const Bank = () => {
    const cleanbank = {
        accountNumber: "",
        accountHolder: "",
        transactions: "",
        balance: "",
    };
    const cleanbank2 = {
        accountNumber: "",
        transaction_amount: 0.0,
    };
    const [bank, setBank] = useState(cleanbank);
    const [bank_transaction, setBankTransaction] = useState(cleanbank2);
    const [banklist, setBanklist] = useState([]);
    const [errors, setErrors] = useState({});
    const [error2s, setError2s] = useState({});

    useEffect(() => {
        loadBanks();
    }, []);

    const validateField = (name, value) => {
        if (!value && name in ['accountNumber','accountHolder']) {
            return '${name.charAt(0).toUpperCase() + name.slice(1)} is required.';
        }
        if ((name === 'accountNumber') && !/^\d+$/.test(value)) {
            return '${name.charAt(0).toUpperCase() + name.slice(1)} must be numeric.';
        }
        return '';
    };

    const handleFieldChange = (e) => {
        const { name, value } = e.target;
        const error = validateField(name, value);
        setErrors({
            ...errors,
            [name]: error
        });
        setBank({
            ...bank,
            [e.target.name]: value
        });
    };
    const validateField2 = (name, value) => {
        if (!value) {
            return '${name.charAt(0).toUpperCase() + name.slice(1)} is required.';
        }
        if ((name === 'accountNumber' || name === 'transaction_amount') && !/^\d+$/.test(value)) {
            return '${name.charAt(0).toUpperCase() + name.slice(1)} must be numeric.';
        }
        return '';
    };
    const handleFieldChange2 = (e) => {
        const { name, value } = e.target;
        const error = validateField2(name, value);
        setError2s({
            ...error2s,
            [name]: error
        });
        setBankTransaction({
            ...bank_transaction,
            [e.target.name]: value
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        let valid = true;
        const newErrors = {};
        Object.keys(bank).forEach(key => {
            console.log("key--------key",key);
            if (key !== "transactions"){
                const error = validateField(key, bank[key]);
                if (error) {
                    newErrors[key] = error;
                    valid = false;
                }
            }
            
        });
        setErrors(newErrors);
        if (!valid) {
            console.log("Validation failed:", newErrors);
            return;
        }
        console.log("Validation passed, calling the server to add bank.");
        addBank(bank);
        setBank(cleanbank);
    };
    

    const addBank = (bank) => {
        console.log("Added bank", bank);
        let data_bank = {
            accountNumber: bank.accountNumber,
            accountHolder: bank.accountHolder,
            transactions: [],
            balance: bank.balance,
        }
        console.log("Added bank", data_bank);
        axios.post("http://localhost:8080/createAccount", data_bank)
            .then((response) => {
                console.log("Added bank", response.data);
                
                loadBanks();
            })
            .catch(error => {
                console.error("Failed to add bank", error);
            });
    };

    const loadBanks = () => {
        axios.get("http://localhost:8080/bankAccounts")
            .then((response) => {
                const updatedData = response.data.map(account => ({
                    ...account,
                    transactions: JSON.stringify(account.transactions) // Convert transactions object to a string
                }));
    
                setBanklist(updatedData); 
            })
            .catch(error => {
                console.error("Failed to load banks", error);
            });
    };

    const removeBank = (accountNumber) => {
        const url = 'http://localhost:8080/bankAccounts/${accountNumber}';
        console.log("Removing bank with URL=" + url);
        axios.delete(url)
            .then(() => {
                console.log("Removed bank " + accountNumber);
                loadBanks();
            })
            .catch(error => {
                console.error("Failed to remove bank", error);
            });
    };

    const deposit = (accountNumber, amount) => {
        console.log("deposit bank with URL=" + accountNumber,"  ",amount);
        const url = `http://localhost:8080/bankAccounts/deposit/${accountNumber}/${amount}`;
        console.log("deposit bank with URL=" + url);
        axios.put(url)
            .then(() => {
                console.log("deposit bank " + accountNumber);
                loadBanks();
            })
            .catch(error => {
                console.error("Failed to deposit bank", error);
            });
    };
    const withdraw = (accountNumber, amount) => {
        console.log("withdraw bank with URL=" + accountNumber,"  ",amount);
        const url = `http://localhost:8080/bankAccounts/withdraw/${accountNumber}/${amount}`;
        
        console.log("withdraw bank with URL=" + url);
        axios.put(url)
            .then(() => {
                console.log("withdraw bank " + accountNumber);
                loadBanks();
            })
            .catch(error => {
                console.error("Failed to withdraw bank", error);
            });
    };
    return (
        <div>
            <h1>Banks</h1>
            <button onClick={loadBanks}>Load banks</button>
            <table>
                <thead>
                    <tr><th>Account Number</th><th>Account Holder</th><th>Transactions</th><th>Balance</th><th>Action</th></tr>
                </thead>
                <tbody>
                    {banklist.map((bank, index) => (
                        <tr key={index}>
                            <td>{bank.accountNumber}</td>
                            <td>{bank.accountHolder}</td>
                            <td>{bank.transactions}</td>
                            <td>{bank.balance}</td>
                            <td><button onClick={() => removeBank(bank.accountNumber)}>Remove</button></td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <h2>Add a new Bank</h2>
            <form onSubmit={handleSubmit}>
                <div>
                Account Number
                    <input
                        type="text"
                        placeholder="Account Number"
                        name="accountNumber"
                        value={bank.accountNumber}
                        onChange={handleFieldChange} />
                    {errors.accountNumber && <div style={{ color: 'red' }}>{errors.accountNumber}</div>}
                </div>
                <div>
                Account Holder
                    <input
                        type="text"
                        placeholder="Account Holder"
                        name="accountHolder"
                        value={bank.accountHolder}
                        onChange={handleFieldChange} />
                    {errors.accountHolder && <div style={{ color: 'red' }}>{errors.accountHolder}</div>}
                </div>
                <button type="submit">Add Bank</button>
            </form>

            <h2>Transactions</h2>
            {/* <form> */}
                <div>
                Account Number
                    <input
                        type="text"
                        placeholder="Account Number"
                        name="accountNumber"
                        value={bank_transaction.accountNumber}
                        onChange={handleFieldChange2} />
                    {error2s.accountNumber && <div style={{ color: 'red' }}>{error2s.accountNumber}</div>}
                </div>
                <div>
                Transaction Amount
                    <input
                        type="text"
                        placeholder="Transaction Amount"
                        name="transaction_amount"
                        value={bank_transaction.transaction_amount}
                        onChange={handleFieldChange2} />
                    {error2s.transaction_amount && <div style={{ color: 'red' }}>{error2s.transaction_amount}</div>}
                </div>
                <button onClick={() => deposit(bank_transaction.accountNumber, bank_transaction.transaction_amount)}>Deposit</button>
                <button onClick={() => withdraw(bank_transaction.accountNumber, bank_transaction.transaction_amount)}>Withdraw</button>
            {/* </form> */}
        </div>
    );
};

export default Bank;