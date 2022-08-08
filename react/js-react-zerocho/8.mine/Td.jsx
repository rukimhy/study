import React, { memo, useCallback, useContext, useMemo } from "react";
import { TableContext, CODE, OPEN_CELL, CLICK_MINE, FLAG_CELL, QUESTION_CELL, NORMALIZE_CELL } from "./Mine";

const getTdStyle = (code) => {
    switch (code) {
        case CODE.NORMAL:
            return {
                background: '#444'
            }
        case CODE.MINE:
            return {
                background: '#444'
            }
        case CODE.CLICKED_MINE:
            return {
                background: 'white'
            }
        case CODE.OPEND:
            return {
                background: 'white'
            }
        case CODE.FLAG_MINE:
        case CODE.FLAG:
            return {
                background: 'red'
            }
        case CODE.QUESTION:
        case CODE.QUESTION_MINE:
            return {
                background: 'yellow'
            }
        default:
            return {
                background: 'white'
            }
    }
}

const getTdText = (code) => {
    switch (code) {
        case CODE.NORMAL:
            return '';
        case CODE.MINE:
            return 'X';
        case CODE.CLICKED_MINE:
            return '펑';
        case CODE.FLAG_MINE:
        case CODE.FLAG:
            return '!'
        case CODE.QUESTION:
        case CODE.QUESTION_MINE:
            return '?'
        default:
            return code || '';
    }
}

const Td = memo(({ rowIndex, cellIndex }) => {
    const { tableData, dispatch, halted } = useContext(TableContext);

    const onClickTd = useCallback(() => {
        if (halted) return;

        switch (tableData[rowIndex][cellIndex]) {
            case CODE.OPEND:
            case CODE.FLAG_MINE:
            case CODE.FLAG:
            case CODE.QUESTION:
            case CODE.QUESTION_MINE:
                return;
            case CODE.NORMAL:
                dispatch({ type: OPEN_CELL, row: rowIndex, cell: cellIndex });
                return;
            case CODE.MINE:
                dispatch({ type: CLICK_MINE, row: rowIndex, cell: cellIndex });
                return;
            default:
                return;
        }
    }, [tableData[rowIndex][cellIndex], halted])

    const onRightClickTd = useCallback((e) => {
        e.preventDefault();
        if (halted) return;
        switch (tableData[rowIndex][cellIndex]) {
            case CODE.NORMAL:
            case CODE.MINE:
                dispatch({ type: FLAG_CELL, row: rowIndex, cell: cellIndex });
                return;
            case CODE.FLAG_MINE:
            case CODE.FLAG:
                dispatch({ type: QUESTION_CELL, row: rowIndex, cell: cellIndex });
                return;
            case CODE.QUESTION:
            case CODE.QUESTION_MINE:
                dispatch({ type: NORMALIZE_CELL, row: rowIndex, cell: cellIndex });
                return;
            case CODE.OPEND:
                return;
            default:
                return;
        }
    }, [tableData[rowIndex][cellIndex], halted])

    return <ReatTd onClickTd={onClickTd} onRightClickTd={onRightClickTd} data={tableData[rowIndex][cellIndex]} />

})

const ReatTd = memo(({ onClickTd, onRightClickTd, data }) => {
    return (
        <td style={getTdStyle(data)}
            onClick={onClickTd}
            onContextMenu={onRightClickTd}
        >
            {getTdText(data)}
        </td>
    )
})


export default Td;