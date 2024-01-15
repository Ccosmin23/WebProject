import React, { useState } from 'react';

function Authentication() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = async (event) => {
        event.preventDefault();

        try {
            const response = await fetch('http://localhost:8080/api/public/auth/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },

                body: JSON.stringify({
                    username: "cc",
                    password: "cc",
                }),
            });

            if (response.ok) {
                // Request was successful, handle the response as needed
                const data = await response.text();
                console.log('Response from server:', data);
            } else {
                // Request failed, handle errors
                console.error('Error:', response.statusText);
            }
        } catch (error) {
            console.error('Error:', error.message);
        }
    };


    return (
        <div>
            <form onSubmit={handleSubmit}>
                <label style={{ paddingRight: 13 }}>Username:</label>
                <input
                    type="text"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                />

                <br />



                <label style={{ paddingRight: 17 }}>Password:</label>
                <input
                    type="password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />
                <br />
                <button type="submit">Submit</button>
            </form>
        </div>
    );
}

export default Authentication;
