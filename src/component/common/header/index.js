import React from "react";
import "./header.css";
import { mystore } from "../../store"
import { useState } from "react";
import {  Link, useNavigate } from 'react-router-dom';
import { useSelector } from "react-redux";

const Header = () => {
   // let flag = false;
   const flag = localStorage.getItem("loggedUser") ? true : false
   const navigate = useNavigate();
    // mystore.subscribe(() => { setFlag( mystore.getState()?.loggedin )});

    const logOutHandler = () => {
        mystore.dispatch({type:'LOGGEDOUT'});
        localStorage.removeItem("loggedUser");
        navigate("/");
    }

    return (
        <div className="max-width">
            <img src="./HungerLogo.png" alt="hungerpoint"
                className="header-logo"
            />
            <div className="header-right">
                {/* <div className="header-location-search-container">
                    <div className="location-warpper">
                        <div className="location-icon-name">
                            <i className="fi fi-rr-marker absolute-center location-icon"></i>
                            <div>Pune</div>
                        </div>
                        <div>
                            <i className="fi fi-rr-caret-down absolute-center"></i>
                        </div>
                        <div className="location-search-separator"> </div>
                        <div className="header-searchbar"></div>
                        <i className="fi fi-rr-search absolute-center search-icon"></i>
                        <input placeholder="Search for Hotels" className="search-input" />
                    </div>
                </div> */}
               
                    <div>
                        <div className="profile-wrapper">
                            {/* <i className="fi fi-rr-user  absolute-center "></i> */}
                            {flag && <div> <span className="header-user-name"><Link to="/">Home</Link></span></div>}&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
                            {flag && <div> <span className="header-user-name"><Link to="/cart">ViewCart</Link></span></div>}&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
                            {flag && <div> <span className="header-user-name"><button onClick={logOutHandler}>LOGOUT</button></span></div>}
                           {!flag && <div> <span className="header-user-name"><Link to="/login">LOGIN</Link></span></div>}&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
                           {!flag && <div>  <span className="header-user-name"><Link to="/customerregister">REGISTER</Link></span></div>}
                            {/* <i className="fi fi-rr-angle-down absolute-center profile-options-icon"></i>
                             */}
                        </div>

                    </div>
                
                <div className="profile-wrapper">
                    <i className="fi fi-rr-user header-profile-image absolute-center "></i>
                    <span className="header-user-name">{JSON.parse(localStorage.getItem("loggedUser"))?.firstName}</span>
                    {/* <i className="fi fi-rr-angle-down absolute-center profile-options-icon"></i> */}
                </div>
            </div>
        </div>
    )
}

export default Header;