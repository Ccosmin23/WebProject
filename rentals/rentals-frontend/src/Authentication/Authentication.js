import './Authentication.css';
import Form from 'react-bootstrap/Form';
import Stack from 'react-bootstrap/Stack';
import React, {useState} from 'react';

function EmailForm() {
    // Define state to keep track of the email and password input values
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    // Event handler for email input changes
    const handleEmailChange = (event) => {
        setEmail(event.target.value);
    };

    // Event handler for password input changes
    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
    };

    // Function to handle form submission
    const handleSubmit = (event) => {
        event.preventDefault();
        console.log('Email entered:', email);
        console.log('Password entered:', password);
    };

    return (
        <form className="email-form" onSubmit={handleSubmit}>
            <Form.Label>Email</Form.Label>
            <div className="bottom-space-5"/>

            <Form.Control
                type="email"
                placeholder="name@example.com"
                style={{
                    fontSize: '15px',
                    height: '30px',
                }} value={email}
                onChange={handleEmailChange}
            />


            <div className="bottom-space-20"/>

            <Form.Label>Password</Form.Label>
            <div className="bottom-space-5"/>
            <Form.Control
                type="password"
                placeholder="enter your password"
                style={{
                    fontSize: '15px',
                    height: '30px',
                }}
                value={password}
                onChange={handlePasswordChange}
            />

            <div className="bottom-space-20"/>

            <button
                type="submit"
                style={{
                    height: '40px',
                    width: '150px',
                    borderRadius: '18px',
                    background: 'darkblue',
                    color: 'white',
                    fontWeight: 'bold',
                    fontSize: '15px', // Set to a value that suits your design
                }}
            >
                Continue
            </button>
        </form>
    );
}

function VStack() {
    return (
        <Stack gap={3}>
            <EmailForm/>
        </Stack>
    );
}

function App() {
    return (
        <div
            style={{
                display: 'flex',
                alignItems: 'center',
                justifyContent: 'center',
            }}
        >
            <VStack/>
        </div>
    );
}

export default App;