import React, { useState } from 'react';

function App() {
    const [formData, setFormData] = useState('');

    const handleSubmit = async (event) => {
        event.preventDefault();

        try {
            const response = await fetch('http://localhost:8080/api/public/auth/test', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ text: formData }),
            });

            if (!response.ok) {
                throw new Error('Network response are ceva probleme');
            }

            console.log('Request-ul a fost cu succes');
        } catch (error) {
            console.error('avem o eroare!', error);
        }
    };

    const handleChange = (event) => {
        setFormData(event.target.value);
    };

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <label>
                    Text:
                    <input
                        type="text"
                        value={formData}
                        onChange={handleChange}
                    />
                </label>
                <button type="submit">Submit</button>
            </form>
        </div>
    );
}

export default App;
