import React from "react";
import { BrowserRouter, Route, Link } from "react-router-dom";
import Bassball from '../3.baseball/baseball-class';
import RSP from '../5.rsp/RSP-class';
import Lotto from '../6.lotto/Lotto-class';

const Games = () => {
    return (
        <BrowserRouter>
            <div>
                <Link to="/number-baseball">숫자야구</Link><br />
                <Link to="/rsp">가위바위보</Link><br />
                <Link to="/lotto">로또생성기</Link><br />
            </div>
            <div>
                <Route path="/number-baseball" component={Bassball} />
                <Route path="/rsp" component={RSP} />
                <Route path="/lotto" component={Lotto} />
            </div>
        </BrowserRouter>
    )
}

export default Games;