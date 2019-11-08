import React from 'react';
import superAgent from 'superagent';

class ItemTableComponent extends React.Component {
    constructor(props) {
        super(props);
        this.th = this.th.bind(this);
        this.tr = this.tr.bind(this);
        this.td_image = this.td_image.bind(this);

        this.state = {
            items: []
        }
    }

    componentWillMount() {
        let items = ["28445", "28444", "28446", "28447", "28448", "28449", "28466", "28456", "28436", "28426", "28416"]
        let requests = [];
        items.forEach(function (val) {
            requests.push(superAgent.get(`https://api.guildwars2.com/v2/items/${val}`));
        });

        Promise.all(requests).then(function (res) {
            this.setState({ items : res.map(res => res.body) })
        }.bind(this))
    }

    th() {
        return (
            <tr>
                <th>Icon</th>
                <th>Name</th>
                <th>Type</th>
                <th>Level</th>
            </tr>
        );
    }

    tr(item, idx) {
        let { icon, name, type, level } = item;

        return (
            <tr key={idx}>
                <td>{this.td_image(icon)}</td>
                <td>{name}</td>
                <td>{type}</td>
                <td>{level}</td>
            </tr>
        )
    }

    td_image(src, alt) {
        return (
            <img src={src} alt={alt} />
        );
    }

    render() {
        console.log(this.state.items)
        return (
            <table>
                <colgroup>
                    <col width="2%"></col>
                    <col width="50%"></col>
                    <col width="5%"></col>
                    <col width="5%"></col>
                </colgroup>
                <tbody>
                    {this.th()}
                    {
                        this.state.items.map(function (value, idx) {
                            return this.tr(value, idx)
                        }.bind(this))
                    }
                </tbody>
            </table>

        );
    }
}

module.exports = ItemTableComponent;

