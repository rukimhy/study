import React, { memo, useCallback } from "react";
import { CLICK_CELL } from './Tictactoe-hooks';

const Td = memo(({ rowIndex, cellIndex, dispatch, cellData }) => { // context api로 해결
    const onClickTd = useCallback(() => {
        if (cellData) {
            return;
        }
        dispatch({ type: CLICK_CELL, row: rowIndex, cell: cellIndex });
    }, [cellData])

    return (
        <td onClick={onClickTd}>{cellData}</td>
    )
})

export default Td;