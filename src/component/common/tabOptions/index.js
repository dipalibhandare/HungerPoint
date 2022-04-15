import { tab } from "@testing-library/user-event/dist/tab";
import React from "react";
import "./tabOptions.css";

const tabs=[{
    id:1,
    name:"vegetarian",
    active_img:<i className="fi fi-rr-carrot"></i>,
    backdrop:"#FCEEC0",
    inactive_img:<i className="fi fi-rr-carrot"></i>,
},
{
    id:2,
    name:"nonvegetarian",
    active_img:<i className="fi fi-rr-turkey"></i>,
    backdrop:"#FCEEC0",
    inactive_img:<i className="fi fi-rr-turkey"></i>,
}];
const TabOptions=({activetab,setActivetab})=>{
    return(
        <div className="tab-options">
            <div className="max-width options-wrapper">
                {tabs.map((item)=>{
                return <div key={item.name} onClick={()=>setActivetab(item.name)
                } className={`tab-item absolute-center cursor-pointer ${activetab === item.name && "active-tab"}`}>
                       <div className="tab-image-container absolute-center"
                       style={{
                           backgroundColor:'${activetab === item.name ? item.backdrop :"" }',
                       }}
                       >
                           <div  className="tab-image" > {
                               activetab === item.name ? item.active_img: item.inactive_img
                           }
                           </div>
                        </div>
                        <div className="tab-name">
                           {item.name}
                        </div>
                </div>
                 })}
            </div>
            
        </div>
    )
}

export default TabOptions;