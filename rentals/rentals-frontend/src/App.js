import React, { useState, useEffect } from 'react';
import './App.css';
import Authentication from './Authentication/Authentication';
import './Authentication/Authentication.css';
import Stack from 'react-bootstrap/Stack';

function PageTitle() {
    return (
        <div>
            <page-title>Pillow</page-title>
        </div>
    );
}

function ContentPage() {
    return (
        <Stack gap={3}>
            <PageTitle />
            <Authentication />
        </Stack>
    );
}

function App() {
    const [showAuthentication, setShowAuthentication] = useState(true); // Initial state, set to true or false based on your backend response

    // Assume you have a function to fetch data from the backend
    const fetchDataFromBackend = async () => {
        try {
            // Make a backend API call to get the response
            const response = await fetch('http://localhost:8080/api/public/get/user');
            const data = await response.json();

            // Assuming the backend response contains a flag to determine whether to show Authentication
            setShowAuthentication(data.showAuthentication);
        } catch (error) {
            console.error('Error fetching data from the backend:', error);
        }
    };

    useEffect(() => {
        // Fetch data from the backend when the component mounts
        fetchDataFromBackend();
    }, []); // The empty dependency array ensures that the effect runs only once when the component mounts

    return (
        <div
            style={{
                display: 'flex',
                alignItems: 'center',
                justifyContent: 'center',
            }}
        >
            {showAuthentication && <ContentPage />}
        </div>
    );
}

export default App;
