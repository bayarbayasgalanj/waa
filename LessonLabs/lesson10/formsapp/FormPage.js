import React, { useState } from 'react';

export const FormPage = () =>{
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');

    let formpage = (
       <form>
         <h3>Enter your information</h3>
         <div>
            <input 
              type="text" 
              placeholder="Name"
              value={name}
              onChange={e => setName(e.target.value)} />
         </div>
         <div>
            <input 
              type="text" 
              placeholder="Email"
              value={email}
              onChange={e => setEmail(e.target.value)} />
         </div>

         <button onClick={e => {
         alert(`Your name is ${name}, your email is ${email}`);
            e.preventDefault();
         }}>Submit</button>

         <p>Name = {name}</p>
         <p>Email = {email}</p>
       </form>
    );
    return formpage;
}
