import React from "react";

import { mystore } from "../component/store";

export default class MenuList extends React.Component{

    constructor(props){
        super(props);
        this.state = {
            menus: []
        }
    }

    // componentDidMount=()=>{
        
    //     fetch("http://localhost:8081/menu/getAll",reqOptions)
    //     .then(r => r.json())
    //     .then(d => this.setState({emps: d}))
    //     localStorage.setItem("MenuList",this.state.menus);

    // }
    }