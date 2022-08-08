import React, { Component } from "react";
import Baseball from '../3.baseball/baseball-class';
import RSP from '../5.rsp/RSP-class';
import Lotto from '../6.lotto/Lotto-class';

export default class GameMatcher extends Component {
    render() {
        let urlSearchParams = new URLSearchParams(this.props.location.search.slice(1));
        console.log(urlSearchParams.get('hello'));

        console.log(this.props);
        if (this.props.match.params.name === 'number-baseball') {
            console.log(this.props.match.params.name);
            return <Baseball />
        } else if (this.props.match.params.name === 'rsp') {
            console.log(this.props.match.params.name);
            return <RSP />
        } else if (this.props.match.params.name === 'lotto') {
            console.log(this.props.match.params.name);
            return <Lotto />
        } else {
            return (
                <div>
                    일치하는 게임이 없습니다.
                </div>
            )
        }
    }
}