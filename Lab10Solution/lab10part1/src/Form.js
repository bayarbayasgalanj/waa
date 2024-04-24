import React, { useState } from 'react';

function Form() {
    const [formData, setFormData] = useState({
        firstname: '',
        lastname: '',
        street: '',
        city: '',
        zip: '',
        state: '',
        email: '',
        phone: '',
        eyeColor: '',
        hobbies: []
    });
    const [result, setResult] = useState("");

    const handleInputChange = (e) => {
        const { name, value, type, checked } = e.target;
        if (type === "checkbox") {
            setFormData(prev => ({
                ...prev,
                hobbies: checked
                    ? [...prev.hobbies, value]
                    : prev.hobbies.filter(h => h !== value)
            }));
        } else if (type === "radio" && checked) {
            setFormData(prev => ({ ...prev, [name]: value }));
        } else {
            setFormData(prev => ({ ...prev, [name]: value }));
        }
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        setResult(JSON.stringify(formData, null, 2));
    };

    return (
        <form onSubmit={handleSubmit}>
            <table>
                <tbody>
                    <tr>
                        <td>Firstname:</td>
                        <td><input name="firstname" value={formData.firstname} onChange={handleInputChange} placeholder="Firstname" /></td>
                    </tr>
                    <tr>
                        <td>Lastname:</td>
                        <td><input name="lastname" value={formData.lastname} onChange={handleInputChange} placeholder="Lastname" /></td>
                    </tr>
                    <tr>
                        <td>Street:</td>
                        <td><input name="street" value={formData.street} onChange={handleInputChange} placeholder="Street" /></td>
                    </tr>
                    <tr>
                        <td>City:</td>
                        <td><input name="city" value={formData.city} onChange={handleInputChange} placeholder="City" /></td>
                    </tr>
                    <tr>
                        <td>Zip:</td>
                        <td><input name="zip" value={formData.zip} onChange={handleInputChange} placeholder="Zip" /></td>
                    </tr>
                    <tr>
                        <td>State:</td>
                        <td>
                            <select name="state" value={formData.state} onChange={handleInputChange}>
                                <option value="">Select State</option>
                                <option value="CA">California</option>
                                <option value="TX">Texas</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><input name="email" value={formData.email} onChange={handleInputChange} placeholder="Email" /></td>
                    </tr>
                    <tr>
                        <td>Phone:</td>
                        <td><input name="phone" value={formData.phone} onChange={handleInputChange} placeholder="Phone" /></td>
                    </tr>
                    <tr>
                        <td>Eye color:</td>
                        <td>
                            <label><input type="radio" name="eyeColor" value="Blue" checked={formData.eyeColor === 'Blue'} onChange={handleInputChange} /> Blue</label>
                            <label><input type="radio" name="eyeColor" value="Green" checked={formData.eyeColor === 'Green'} onChange={handleInputChange} /> Green</label>
                            <label><input type="radio" name="eyeColor" value="Brown" checked={formData.eyeColor === 'Brown'} onChange={handleInputChange} /> Brown</label>
                        </td>
                    </tr>
                    <tr>
                        <td>Hobbies:</td>
                        <td>
                            <label><input type="checkbox" name="hobbies" value="Reading" onChange={handleInputChange} /> Reading</label>
                            <label><input type="checkbox" name="hobbies" value="Gaming" onChange={handleInputChange} /> Gaming</label>
                            <label><input type="checkbox" name="hobbies" value="Traveling" onChange={handleInputChange} /> Traveling</label>
                        </td>
                    </tr>
                    <tr>
                        <td colSpan="2"><button type="submit">Submit</button></td>
                    </tr>
                </tbody>
            </table>
            <div>
                <h2>Result:</h2>
                <pre>{result}</pre>
            </div>
        </form>
    );
}

export default Form;
