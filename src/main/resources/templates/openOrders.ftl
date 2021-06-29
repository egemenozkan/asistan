<#import "tools/layout.ftl" as layout>

<@layout.basic>
<table>
    <#if asks??>
        <thead>
        <tr>
            <th>Pair Symbol.</th>
            <th>Amount</th>
            <th>Left Amount</th>
            <th>Method</th>
            <th>Quantity</th>
            <th>Status</th>
            <th>Stop Price</th>
            <th>type</th>
            <th>id</th>
        </tr>
        </thead>
        <tbody>
        <#list asks as order>
            <tr>
                <td>${ order.pairSymbol }</td>
                <td>${ order.amount }</td>
                <td>${ order.leftAmount }</td>
                <td>${ order.method }</td>
                <td>${ order.quantity }</td>
                <td>${ order.status }</td>
                <td>${ order.stopPrice }</td>
                <td>${ order.type }</td>
                <td>${ order.id }</td>
            </tr>
        <#else>
            <tr>
                <td colspan="2">Ticker yok</td>
            </tr>
        </#list>
        </tbody>
    </#if>


</table>

<table>
    <#if bids??>
        <thead>
        <tr>
            <th>Pair Symbol.</th>
            <th>Amount</th>
            <th>Left Amount</th>
            <th>Method</th>
            <th>Quantity</th>
            <th>Status</th>
            <th>Stop Price</th>
            <th>type</th>
            <th>id</th>
        </tr>
        </thead>
        <tbody>
        <#list bids as order>
            <tr>
                <td>${ order.pairSymbol }</td>
                <td>${ order.amount }</td>
                <td>${ order.leftAmount }</td>
                <td>${ order.method }</td>
                <td>${ order.quantity }</td>
                <td>${ order.status }</td>
                <td>${ order.stopPrice }</td>
                <td>${ order.type }</td>
                <td>${ order.id }</td>
            </tr>
        <#else>
            <tr>
                <td colspan="2">Ticker yok</td>
            </tr>
        </#list>
        </tbody>
    </#if>


</table>
</@layout.basic>