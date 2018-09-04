<%@ page language="java"%>

<body>

	
	
	
	
	
	
	
	
	
	
	<span id="cntnttitle">Stock Purchase and Deferral Plan<br />
		Distribution Statement<br />As of 
		
						3/10/2016
		<span id="cntntnum">Report ID: SPDP_D1</span>
	</span>
	<span id="cntnthead"> <font class="fntbld">Name:</font>Philip 
		Abrahams
	</span>
	<span id="content">
	
	<form name="reportForm" method="post" action="/ECS/dcSPDPStmtDistribution.do" target="_self">
	<input type="hidden" name="methodName" value="exportPDF">
	
	    
<form name="vinform">  
<input type="text" name="t1">  
<input type="button" value="ShowTable" onClick="createPdf()">  
</form>  
 
<span id="amit"> </span>  
	
	<br><br>
	<a href="/ECS/upload?f=0" onclick="makeRequest()">download</a>
	
	<br><br>
		<strong>Download Options:</strong>
		<select name="cbDownload" onchange="download('0')">
		<option value="">Make a Selection...</option>
		<option value="un_full_excel">Export to Excel with NO Formatting</option>
		<option value="full_excel">Export to Excel with text Formatting</option>
		<option value="full_word">Export to Word</option>
		<option value="full_pdf">Export to PDF</option></select>
	
	
		<p>

			Shown below is information, which explains the distribution of your
			Stock Purchase and Deferral Plan for
			102
			shares distributed
			
						March 09, 2016
			The Fair Market Value established on
			
						March 09, 2016
			was
			37.980000
			per share and represents your tax basis. The distribution of your
			Pre-Tax and Company Match account, when available for distribution,
			is subject to Federal, state and local taxes, as applicable. Any
			fractional share was included in your Federal withholding. Wages and
			taxes related to this distribution will appear in the year-to-date
			totals of your paycheck dated on or about April 6 and on a Form W-2
			issued by AT&T Inc.<br /> <br />
		</p>

		<table width="900" cellspacing="0" border="0">

			<thead>
				<tr>
					<th colspan="3" class="primeheaderright">&nbsp;</th>
					<th colspan="8" class="primeheader">Taxes</th>
					<th colspan="2" class="primeheader noborder">&nbsp;</th>
				</tr>
				<tr>
					<th class="full">&nbsp;</th>
					<th colspan="2">Gross (Wages)</th>
					<th colspan="2">Federal (25%)
					</th>
					<th colspan="2">Federal (39.6%)
					</th>
					<th colspan="2">State (3.75% IL)
					</th>
					<th colspan="2">Local (0.00% )
					</th>
					<th colspan="2">Net</th>
				</tr>
				<tr>
					<th class="tieredfull">Plan <br />Year
					</th>
					<th class="tiered">Shares</th>
					<th class="tiered">Values</th>
					<th class="tiered">Shares</th>
					<th class="tiered">Values</th>
					<th class="tiered">Shares</th>
					<th class="tiered">Values</th>
					<th class="tiered">Shares</th>
					<th class="tiered">Values</th>
					<th class="tiered">Shares</th>
					<th class="tiered">Values</th>
					<th class="tiered">Shares</th>
					<th class="tiered">Values</th>
				</tr>
			</thead>

			<tbody>
	    	 
				<tr>
					<td class="full">2015</td>
					<td class="full">143.6714</td>
					<td class="full">
					$5,456.64</td>
					<td class="full">
					36.2837</td>
					<td class="full">
					$1,378.05</td>
					<td class="full">
					0</td>
					<td class="full">
					$0</td>
					<td class="full">
					5.3877</td>
					<td class="full">
					$204.62</td>
					<td class="full">
					0</td>
					<td class="full">
					$0</td>
					<td class="full">
					102</td>
					<td class="full">
					$3,873.96</td>
				</tr>
				
				
				
				
				
				
			
			
				<tr>
					<td class="full">2014</td>
					<td class="full">546.4102</td>
					<td class="full">
					$20,752.66</td>
					<td class="full">
					136.9198</td>
					<td class="full">
					$5,200.21</td>
					<td class="full">
					0</td>
					<td class="full">
					$0</td>
					<td class="full">
					20.4904</td>
					<td class="full">
					$778.23</td>
					<td class="full">
					0</td>
					<td class="full">
					$0</td>
					<td class="full">
					389</td>
					<td class="full">
					$14,774.22</td>
				</tr>
				
				
				
				
				
				
			
				
			
			 
			 
			 <tfoot>
				<tr>
					<td>W-2 Total:</td>
					<td>
					690.0816</td>
					<td>$26,209.3</td>

					<td>
					173.2035</td>
					<td>$6,578.27</td>

					<td>
					0</td>
					<td>$0</td>

					<td>
					25.8781</td>
					<td>$982.85</td>

					<td>
					0</td>
					<td>$0</td>

					<td>491</td>
					<td>$18,648.18</td>
				</tr>
				<tfoot>
				
			</tbody>
		</table> 
		
		
		<p>
			Federal withholding rate is
			25%
			until year-to-date taxable supplemental wages exceed $1 million, at
			which time the rate increases to
			39.6%.
		</p> 
	<span class="cntntnotecount blue">NOTES:</span> <br> <span
		class="cntntverbiageblockbody"> <b>State taxes were
				withheld as follows:</b>
	</span> <span class="cntntverbiageblockbody"> <b>Active
				participants:</b> The tax rate is based on your work address if your
			employing company does business in that state; otherwise, it is zero.
	</span> <span class="cntntverbiageblockbody"> <b>Retired or
				terminated participants:</b> The tax rate is based on your residence
			address if your former company does business in that state;
			otherwise, it is zero.
	</span> <span class="cntntverbiageblockbody"> <b>Uncertificated
				shares:</b>
	</span> <span class="cntntverbiageblockbody"> Stock distributed to you
			will be registered in your name and issued in uncertificated form on
			or after the next business day following 
						3/10/2016.
			You will receive confirmation of the transaction at your home address
			from our transfer agent, Computershare (<a
			href="http://www.computershare.com/att" target="_blank">www.computershare.com/att</a>).
			You may also contact Computershare at 1-800-351-7221.
	</span> <br> 




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Stock Purchase and Deferral Plan</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">



<link rel="STYLESHEET" type="text/css"
	href="/execcompstatic/css/execcomp.css">
</head>
<body>
	<p>
		Every attempt has been made to be as accurate as possible in the
		preparation of this document. Questions regarding its contents should
		be referred to Janis Rivera at (214) 757-5856, or by
		email: <a href="mailto:g10934@att.com"> g10934@att.com</a>

	</p>


</body>