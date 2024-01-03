import React, { useState } from "react";
import styles from "./Navbar.module.scss";

import { useNavigate, Link } from "react-router-dom";

import { useSelector, useDispatch } from "react-redux";

const Navbar = () => {


  return (
    <div className={styles.navbar}>
      <div className={styles.logo}>
        <img alt="logo" src="../../../logo1.png" />
        <h4>THINKING PAD</h4>
      </div>
    </div>
  );
};

export default Navbar;
