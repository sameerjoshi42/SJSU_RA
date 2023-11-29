import './App.css';
import { BrowserRouter,Routes,Route } from 'react-router-dom';
import Landing from './Pages/Landing';
import FileUpload from './Components/FileUpload';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
      <Routes>

        <Route index element={<Landing/>}/>
        {/* <Route path='/upload' Component={FileUpload}></Route> */}
      </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
