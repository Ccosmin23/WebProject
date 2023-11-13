import './App.css';
import Form from 'react-bootstrap/Form';
import Stack from 'react-bootstrap/Stack';

function PageTitle() {
    return (
      <div style = {{
          display: 'flex',
          alignItems: 'center',
          justifyContent: 'center',
      }}>
          <page-title>Pillow</page-title>
      </div>
    );
}

function ContinueButton() {
  return (
      <div>
          <button>
              Continue
          </button>
      </div>
  );
}

function EmailForm() {
    return (
        <div>
            <Form.Label>
                Email address
            </Form.Label>

            <span className = { "space-between-label-and-text" } />

            <Form.Control
                type = "email"
                placeholder = "name@example.com"
            />
        </div>
    );
}

function VStack() {
    return (
        <Stack gap={3}>
            <div className="p-2">
                <PageTitle/>
            </div>

            <div className="p-2">
                <EmailForm/>
            </div>

            <div className = { "space-left" }
            >
                <ContinueButton/>
            </div>
        </Stack>
    );
}

function App() {
    return (
        <div
            style = {{
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

