import React, { useState, useRef } from 'react';
import Try from './Try-hooks';

const getNumbers = () => {

    const candidate = [1, 2, 3, 4, 5, 6, 7, 8, 9];
    const array = [];
    for (let i = 0; i < 4; i++) {
        const chosen = candidate.splice(Math.floor(Math.random() * candidate.length), 1)[0];
        array.push(chosen);
    }
    console.log(array);
    return array;
}

const BaseBall = () => {
    const [result, setResult] = useState('');
    const [value, setValue] = useState('');
    const [answer, setAnswer] = useState(getNumbers);
    const [tries, setTries] = useState([]);
    const inputEl = useRef(null);

    const onSubmitForm = (e) => {
        e.preventDefault();
        if (!value || !Number(value)) {
            setValue('');
            return;
        }
        if (value === answer.join('')) {
            setResult('홈런!');
            setTries((prevTries) => {
                return [...prevTries, {
                    try: value,
                    result: '홈런!',
                }]
            })

            setTimeout(() => {
                alert('게임을 다시 시작합니다.');
                setValue('');
                setAnswer(getNumbers());
                setTries([]);
                setResult('');
                inputEl.current.focus();
            }, 500);
        } else {
            const answerArray = value.split('').map((v) => parseInt(v));
            let strike = 0;
            let ball = 0;
            if (tries.length >= 9) {
                setResult(`10번 넘게 틀려서 실패! 답은 ${answer.join(',')}였습니다.`);

                setTimeout(() => {
                    alert('게임을 다시 시작합니다.');
                    setValue('');
                    setAnswer(getNumbers());
                    setTries([]);
                    setResult('');
                    inputEl.current.focus();
                }, 500);
            } else {
                for (let i = 0; i < 4; i++) {
                    if (answerArray[i] === answer[i]) {
                        strike++;
                    } else if (answer.includes(answerArray[i])) {
                        ball++;
                    }
                }
                setValue('');
                setTries((prevTries) => {
                    return [...prevTries, {
                        try: value,
                        result: `${strike} 스트라이크, ${ball} 볼입니다.`,
                    }]
                })
            }
            inputEl.current.focus();
        }
    }

    const onChangeInput = (e) => {
        setValue(e.target.value);
    }

    return (
        <>
            <h1>{result}</h1>
            <form onSubmit={onSubmitForm}>
                <input ref={inputEl} autoFocus minLength={4} maxLength={4}
                    value={value} onChange={onChangeInput} />
            </form>
            <div>시도: {tries.length}</div>
            <ul>
                {tries.map((v, i) => {
                    return (
                        <Try key={`${i + 1}차 시도 : `} tryInfo={v} index={i} />
                    )
                })}
            </ul>
        </>
    )
}

export default BaseBall;