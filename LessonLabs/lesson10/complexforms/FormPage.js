import React, { useState } from 'react';

export const FormPage = () => {
   const [name, setName] = useState('');
   const [country, setCountry] = useState('');
   const [haircolor, setHaircolor] = useState('');

   let formpage = (
      <div>
         <form>
            <h3>Enter your information</h3>
            <table>
               <tr>
                  <td>Name</td>
                  <td><input
                     type="text"
                     value={name}
                     onChange={e => setName(e.target.value)} />
                     </td>
               </tr>
               <tr>
                  <td>Country</td>
                  <td><select
                     type="text"
                     value={country}
                     onChange={e => setCountry(e.target.value)} >
                     <option>USA</option>
                     <option>India</option>
                     <option>China</option>
                     <option>Russia</option>
                  </select>
                  </td>
               </tr>
               <tr>
                  <td>Hair color</td>
                  <td><input
                     type="radio"
                     value="Black"
                     checked={haircolor === "Black"}
                     onChange={e => setHaircolor(e.target.value)}
                  />Black</td>
                  <td><input
                     type="radio"
                     value="Brown"
                     checked={haircolor === "Brown"}
                     onChange={e => setHaircolor(e.target.value)}
                  />Brown</td>
               </tr>
            </table>
         </form>

         <p>Name = {name}</p>
         <p>Country = {country}</p>
         <p>Haircolor = {haircolor}</p>
      </div>
   );
   return formpage;
}
