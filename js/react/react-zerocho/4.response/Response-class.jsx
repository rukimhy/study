import React, { Component } from 'react';

class Response extends Component {

    state = {
        state: 'waiting',
        message: '클릭해서 시작하세요.',
        result: [],
    }

    timeout;
    startTime;
    endTime;

    onClickScreen = () => {
        const { state, message, result } = this.state;
        if (state === 'waiting') {
            this.setState({
                state: 'ready',
                message: '초록색이 되면 클릭하세요.',
            })
            this.timeout = setTimeout(() => {
                this.setState({
                    state: 'now',
                    message: '지금 클릭하세요!!!'
                })
                this.startTime = new Date();
            }, Math.floor(Math.random() * 1000 + 2000));
        } else if (state === 'ready') {
            this.setState({
                state: 'waiting',
                message: '클릭해서 시작하세요.'
            })
            alert('너무 성급하시군요!');
            clearTimeout(this.timeout);
        } else if (state === 'now') {
            this.endTime = new Date();
            // 옛날 값을 배열에 저장할 때 prevState
            this.setState((prevState) => {
                return {
                    state: 'waiting',
                    message: '클릭해서 시작하세요.',
                    result: [...prevState.result, this.endTime - this.startTime],
                }
            })
        }
    }

    onReset = () => {
        this.setState({
            result: []
        })
    }

    render() {
        return (
            <>
                <div id="screen" className={this.state.state} onClick={this.onClickScreen}>
                    {this.state.message}
                </div>
                {this.state.result.length === 0 ? null : <>
                    <div>평균 시간: {this.state.result.reduce((a, c) => a + c) / this.state.result.length}ms</div>
                    <button onClick={this.onReset}>리셋</button>
                </>
                }
            </>
        )
    }

}

export default Response;