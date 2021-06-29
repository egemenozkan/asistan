<#import "tools/layout.ftl" as layout>

<@layout.basic>
    <table>
    <#if tickers??>
        <thead>
        <tr>
            <th>Base C.</th>
            <th>Currency</th>
            <th>last</th>
            <th>low</th>
            <th>high</th>
            <th>daily</th>
            <th>dailyPercent</th>
            <th>average</th>
            <th>open</th>
            <th>ask</th>
            <th>bid</th>
        </tr>
        </thead>
        <tbody>
        <#list tickers as ticker>
            <tr>
                <td>${ ticker.numeratorSymbol }</td>
                <td>${ ticker.denominatorSymbol }</td>
                <td>${ ticker.last }</td>
                <td>${ ticker.low }</td>
                <td>${ ticker.high }</td>
                <td>${ ticker.daily }</td>
                <td>${ ticker.dailyPercent }</td>
                <td>${ ticker.average }</td>
                <td>${ ticker.open }</td>
                <td>${ ticker.ask }</td>
                <td>${ ticker.bid }</td>
            </tr>
        <#else>
            <tr>
                <td colspan="2">Ticker yok</td>
            </tr>
        </#list>
        </tbody>
    </#if>

</@layout.basic>