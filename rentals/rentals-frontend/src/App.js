import './App.css';
import Stack from 'react-bootstrap/Stack';
import Authentication from "./Authentication/Authentication";

function PageTitle() {
    return (
        <div>
            <page-title>Pillow</page-title>
        </div>
    );
}

function AppVStack() {
    return (
        <Stack gap={3}>
            <PageTitle/>
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
            <AppVStack/>
        </div>
    );
}

export default App;

