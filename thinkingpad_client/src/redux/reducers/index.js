import { combineReducers } from "redux";

//Reducers import

import alertReducer from "./alertReducer";


const rootReducer = combineReducers({

  alert: alertReducer,

});
export default rootReducer;
