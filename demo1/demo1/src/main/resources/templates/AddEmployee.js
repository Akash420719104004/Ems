import React, { useState } from 'react';
import axios from 'axios';

const AddEmployee = () => {
  const [employee, setEmployee] = useState({
    name: '',
    mobileNo: '',
    position: '',
    department: '',
    salary: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setEmployee({
      ...employee,
      [name]: value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    // Ensure salary is a number
    const employeeData = {
      ...employee,
      salary: parseFloat(employee.salary),
    };

    try {
      const response = await axios.post('http://localhost:8080/addEmployee', employeeData);
      alert('Employee added successfully!');
    } catch (error) {
      console.error('There was an error adding the employee!', error);
    }
  };

  return (
    <div>
      <h2>Add Employee</h2>
      <form onSubmit={handleSubmit}>
        <label>Name:</label>
        <input type="text" name="name" value={employee.name} onChange={handleChange} required />
        <br />
        <label>Mobile No:</label>
        <input type="text" name="mobileNo" value={employee.mobileNo} onChange={handleChange} required />
        <br />
        <label>Position:</label>
        <input type="text" name="position" value={employee.position} onChange={handleChange} required />
        <br />
        <label>Department:</label>
        <input type="text" name="department" value={employee.department} onChange={handleChange} required />
        <br />
        <label>Salary:</label>
        <input type="number" name="salary" value={employee.salary} onChange={handleChange} required />
        <br />
        <button type="submit">Add Employee</button>
      </form>
    </div>
  );
};

export default AddEmployee;
