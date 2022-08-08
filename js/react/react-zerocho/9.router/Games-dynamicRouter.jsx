import React from "react";
import { BrowserRouter, Route, Link } from "react-router-dom";
import GameMatcher from "./GameMatcher";

const Games = () => {
    return (
        <BrowserRouter>
            <div>
                <Link to="/game/number-baseball?query=10&hello=zerocho">숫자야구</Link><br />
                <Link to="/game/rsp">가위바위보</Link><br />
                <Link to="/game/lotto">로또생성기</Link><br />
                <Link to="/game/index">게임매쳐</Link><br />
            </div>
            <div>
                <Route path="/game/:name" component={GameMatcher} />
            </div>
        </BrowserRouter>
    )
}

export default Games;