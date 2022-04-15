import { createStore } from "redux";
// import reducer from "./reducer";

const initialState = { 
    loggedin: localStorage.getItem("loggedUser") ? true : false,
    carddetails: []
}

const reducer = (state = initialState, action) => {

    switch(action.type)
    {
        case 'LOGGEDIN':
            return {...state, loggedin: true }
        case 'LOGGEDOUT':
            return {...state, loggedin: false }
        case 'Add_To_Cart':
            const isDuplicate = state.carddetails.find(menuItem => menuItem.menuId === action.payload.menuId);
            if (isDuplicate) {
                state.carddetails.forEach((menuItem) => {
                    if (menuItem.menuId === action.payload.menuId) {
                        menuItem.qty = menuItem.qty + 1;
                    }
                })
                return {...state, carddetails: [...state.carddetails]};
            }
            return {...state, carddetails: [...state.carddetails, action.payload]};
        case 'ADD_QTY':
            state.carddetails.forEach((menuItem) => {
                if (menuItem.menuId === action.payload) {
                    menuItem.qty = menuItem.qty + 1;
                }
            })
            return {...state, carddetails: [...state.carddetails]};
        case 'REMOVE_QTY':
            state.carddetails.forEach((menuItem) => {
                if (menuItem.menuId === action.payload) {
                    menuItem.qty = menuItem.qty > 1 ? menuItem.qty - 1 : menuItem.qty;
                }
            })
            return {...state, carddetails: [...state.carddetails]};
        case 'REMOVE_ITEM':
            const menuArr = state.carddetails;
            const index = menuArr.findIndex((menuItem) => menuItem.menuId === action.payload);
            if (index > -1) {
                menuArr.splice(index, 1)
            }
            return {...state, carddetails: [...menuArr]};
    }
}
export const mystore = createStore(reducer,initialState)
