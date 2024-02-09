import React, { useState } from 'react';
import axios from 'axios';

function App() {
    const [itemId, setItemId] = useState('');
    const [responseData, setResponseData] = useState('');

    const handleCreateItem = async () => {
        try {
            const response = await axios.post('http://localhost:8080/update', {
                id: 1, // Replace with your item data
                name: 'New Item' // Replace with your item data
            });
            console.log('Create item response:', response.data);
        } catch (error) {
            console.error('Error creating item:', error);
        }
    };

    const handleListAllItems = async () => {
        try {
            const response = await axios.get('http://localhost:8080/lista');
            console.log('List all items response:', response.data);
            setResponseData(response.data);
        } catch (error) {
            console.error('Error listing all items:', error);
        }
    };

    const handleListItemById = async () => {
        try {
            const response = await axios.get(`http://localhost:8080/item/${itemId}`);
            console.log(`List item by ID (${itemId}) response:`, response.data);
            setResponseData(response.data);
        } catch (error) {
            console.error('Error listing item by ID:', error);
        }
    };

    return (
        <div style={{ padding: '20px' }}>
            <button onClick={handleCreateItem}>Create Item</button>
            <br />
            <button onClick={handleListAllItems}>List All Items</button>
            <br />
            <input type="text" value={itemId} onChange={(e) => setItemId(e.target.value)} />
            <button onClick={handleListItemById}>List Item by ID</button>
            <br />
            <div style={{ marginTop: '20px' }}>
                <h2>Response Data:</h2>
                <pre>{JSON.stringify(responseData, null, 2)}</pre>
            </div>
        </div>
    );
}

export default App;
