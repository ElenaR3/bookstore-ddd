import React from 'react';
import {Link} from 'react-router-dom';

const productTerm = (props) => {
    return (
        <tr>
            <td>{props.term.name}</td>
            <td>{props.term.description}</td>
            <td>{props.term.amount}</td>
            <td>{props.term.currency}</td>
            <td className={"text-right"}>
                <a title={"Delete"} className={"btn btn-danger"}
                   onClick={() => props.onDelete(props.term.id)}>
                    Delete
                </a>
            </td>
        </tr>
    )
}

export default productTerm;
