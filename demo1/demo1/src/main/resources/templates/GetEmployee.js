import React, { useState } from 'react';
import axios from 'axios';

const GetEmployee = () => {
  const [employeeId, setEmployeeId] = useState('');
  const [employee, setEmployee] = useState(null);

  const handleChange = (e) => {
    setEmployeeId(e.target.value);
  };

  const handleSearch = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/getEmployee?id=${employeeId}`);
      setEmployee(response.data);
    } catch (error) {
      console.error('Error fetching employee data', error);
    }
  };

  return (
    <div>
      <h2>Get Employee</h2>
      <input
        type="number"
        placeholder="Enter Employee ID"
        value={employeeId}
        onChange={handleChange}
      />
      <button onClick={handleSearch}>Search</button>

      {employee && (
        <div>
          <h3>Employee Details:</h3>
          <p>Name: {employee.name}</p>
          <p>Mobile No: {employee.mobileNo}</p>
          <p>Position: {employee.position}</p>
          <p>Department: {employee.department}</p>
          <p>Salary: {employee.salary}</p>
        </div>
      )}
    </div>
  );
};

export default GetEmployee;
