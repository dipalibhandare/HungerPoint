import React from "react";
import LocateMe from "./component/LocateMe";
import HomePage from "./pages/home";
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter, Route, Link, Routes} from 'react-router-dom';
import Login from "./component/login";
import CustomerRegister from "./component/customerRegister";
import Header from "./component/common/header";
import Footer from "./component/common/footer";
import ViewCard from "./component/viewCard"

const App=()=>{
return(
  <div>
      
      <BrowserRouter>
      <Header/>
                                <Routes>
                                    <Route path="/" element={<HomePage/>} />
                                    <Route path="/login" element={<Login/>} />
                                    <Route path="/cart" element={<ViewCard/>} />
                                    <Route path="/customerregister" element={<CustomerRegister/>} />
                                </Routes>              
                            
        <Footer/>             
      </BrowserRouter>
      
      {/*<LocateMe/>*/}
  </div>
)

};
export default App;