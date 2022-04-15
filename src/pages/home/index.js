import React, { useEffect, useState } from "react";
import axios from 'axios';

import TabOptions from "../../component/common/tabOptions";
import Vegetarian from "../../component/Vegetarian";
import Nonvegetarian from "../../component/Nonvegetarian";

const HomePage=()=>
{
    const [menus, setMenus] = useState([]);
    const [activetab,setactivetab]=useState("Vegetarian");
    
    useEffect(()=>{ 
                
        axios.get('http://localhost:8080/admin/menu/getAll')
                .then(response => {
                    return response.data
                 })
                .then((data)=>{
               setMenus(data);
               localStorage.setItem("MenuList", JSON.stringify(data));
                })
    },[])
    
    return <div> 
        
        <TabOptions activetab={activetab} setactivetab={setactivetab}/>
       {getCorrectScreen(activetab)}
       
     </div>
}

     const getCorrectScreen=(tab)=>{
        switch(tab)
        {
            case "Vegetarian":
               return <div> <Vegetarian/></div>
            case "NonVegetarian":
                return <div><Nonvegetarian/></div>
        }

        
     }

export default HomePage;