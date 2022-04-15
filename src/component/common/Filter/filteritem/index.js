import React from "react";
import "./filteritem.css";

const FilterItem=({filter})=>{
    return <div kay={filter.title} className="filter-item">{filter.icon && filter.icon}
    <div className="filter-title">{filter.title}</div>
    </div>
}

export default FilterItem;