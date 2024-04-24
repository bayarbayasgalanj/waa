import React, { useState } from 'react';

export const Calculator = () => {
    const [first, setFirst] = useState(0);
    const [second, setSecond] = useState(0);
    const [operator, setOperator] = useState('');
    const [result, setResult] = useState(0);

    let calcpage = (
        <>
            <h3>Calculator</h3>
            <table class="center">
                <tr>
                    <td>First number</td>
                    <td><input
                        type="text"
                        name="first"
                        value={first}
                        onChange={e => setFirst(e.target.value)} /></td>
                </tr>
                <tr>
                    <td>Second number</td>
                    <td><input
                        type="text"
                        name="second"
                        value={second}
                        onChange={e => setSecond(e.target.value)} /></td>
                </tr>
                <tr>
                    <td>Operator</td>
                    <td><select
                        type="text"
                        name="operator"
                        value={operator}
                        onChange={e => setOperator(e.target.value)}>
                        <option>---</option>
                        <option>add</option>
                        <option>subtract</option>
                        <option>multiply</option>
                        <option>divide</option>
                        <option>clear</option>
                    </select></td>
                </tr>

                <td><button onClick={e => {
                    switch (operator) {
                        case "add":
                            console.log("in add");
                            setResult(parseInt(first) + parseInt(second));
                            break;
                        case "subtract":
                            setResult(parseInt(first) - parseInt(second));
                            break;
                        case "multiply":
                            setResult(parseInt(first) * parseInt(second));
                            break;
                        case "divide":
                            setResult(parseInt(first) / parseInt(second));
                            break;
                        case "clear":
                            setResult(0);
                            break;
                        default:
                            setResult(0);
                    }

                }}>Submit</button></td>
                <tr>
                    <td>Result</td>
                    <td>{result}</td>
                </tr>
            </table>
        </>
    );
    return calcpage;
}    