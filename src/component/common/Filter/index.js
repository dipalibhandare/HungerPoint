import React from "react";
import "./filter.css"
import FilterItem from "./filteritem";

const Filter=({filterlist})=>
{
    return (<div className="filters">
       { filterlist && filterlist.map((filter)=>{
           return<div key={filter.id}> <FilterItem filter={filter} /></div>
       })}
    </div>
    )
}


export default Filter;