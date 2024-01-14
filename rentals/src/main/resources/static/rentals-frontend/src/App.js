import './App.css';

import Authentication from "./Authentication/Authentication";
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
            <Authentication/>
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
            <ContentPage />
        </div>
    );
}

export default App;
