import React from 'react';
import './App.css';
import AddEmployee from './AddEmployee';
import GetEmployee from './GetEmployee';

function App() {
  return (
    <div className="App">
      <h1>Employee Management System</h1>
      <AddEmployee />
      <GetEmployee />
    </div>
  );
}

export default App;
