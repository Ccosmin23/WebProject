import React, { useState } from 'react';
import './App.css';
import Form from 'react-bootstrap/Form';
import Stack from 'react-bootstrap/Stack';

function PageTitle() {
    return (
        <div>
            <page-title>Pillow</page-title>
        </div>
    );
}

function EmailForm({ setEmail }) {
    const handleChange = (e) => {
        setEmail(e.target.value);
    };

    return (
        <div className="email-form">
            <Form.Label>Email address</Form.Label>

            <span className="space-between-label-and-input" />

            <Form.Control
                type="email"
                placeholder="name@example.com"
                onChange={handleChange}
            />
        </div>
    );
}

function PasswordForm({ setPassword }) {
    const handleChange = (e) => {
        setPassword(e.target.value);
    };

    return (
        <div className="password-form">
            <Form.Label>Password</Form.Label>

            <span className="space-between-label-and-input" />

            <Form.Control
                type="password"
                placeholder="qwert1234"
                onChange={handleChange}
            />
        </div>
    );
}

function ContinueButton({ email, password }) {
    const handleClick = () => {
        // Use the email and password values as needed
        console.log('Email:', email);
        console.log('Password:', password);
        // Add your logic here, e.g., making an API call with the entered values
    };

    return (
        <div className="space-left">
            <button onClick={handleClick}>Continue</button>
        </div>
    );
}

function VStack() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    return (
        <Stack gap={3}>
            <PageTitle />
            <EmailForm setEmail={setEmail} />
            <PasswordForm setPassword={setPassword} />
            <ContinueButton email={email} password={password} />
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
            <VStack />
        </div>
    );
}

export default App;
