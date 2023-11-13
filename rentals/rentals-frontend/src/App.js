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

function EmailForm() {
    return (
        <div className = {"email-form"} >
            <Form.Label>
                Email address
            </Form.Label>

            <span className = {"space-between-label-and-text"} />

            <Form.Control
                type="email"
                placeholder="name@example.com"
            />
        </div>
    );
}

function PasswordForm() {
    return (
        <div className = "password-form" >
            <Form.Label>
                Password
            </Form.Label>

            <span className={"space-between-label-and-text"}/>

            <Form.Control
                type="password"
                placeholder="qwert1234"
            />
        </div>
    );
}

function ContinueButton() {
    return (
        <div className={"space-left"}>
            <button>
                Continue
            </button>
        </div>
    );
}

function VStack() {
    return (
        <Stack gap={3}>
            <PageTitle/>
            <EmailForm/>
            <PasswordForm/>

            <ContinueButton/>
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

