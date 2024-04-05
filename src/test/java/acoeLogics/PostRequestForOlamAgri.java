package acoeLogics;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostRequestForOlamAgri {


	public static void main(String[] args) {
		try {
			String apiUrl = "https://ncpuat.olamagri.com/bidding/api/Event/SaveEvent";

			URL url = new URL(apiUrl);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("POST");
			String bearer="Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJLcTdwS3VfRklPa3pJaU5RQTJJdnZLa2M0cjdFRE0zYkdyaHQza1BPMHBJIn0.eyJleHAiOjE3MDgwNjE0MzcsImlhdCI6MTcwODA2MTEzNywiYXV0aF90aW1lIjoxNzA4MDYxMTM1LCJqdGkiOiJjZGRiZTc5ZC1kODFmLTRlYjktOGRjNS1lZjdhZGNkNDQzYmYiLCJpc3MiOiJodHRwczovL2RpZ2l0YWxhdXRoZGV2Lm9sYW1uZXQuY29tL2F1dGgvcmVhbG1zL05DUF9VQVQiLCJhdWQiOlsibmNwdWF0IiwiYWNjb3VudCJdLCJzdWIiOiIyYWUzMjM4Zi1mNDdkLTQyZGUtYjkwZi03MjE5OTgyM2ZhM2UiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJuY3B1YXQiLCJub25jZSI6IjdhYmY3NTk0LTg3OWUtNDdiMy1iY2ViLWNmNDI0ZGZkZWNmMSIsInNlc3Npb25fc3RhdGUiOiJmNTI2Yzk3YS0xMDMyLTRlZDMtYTViNy1kYmE2N2JiYjY1NTQiLCJhY3IiOiIxIiwiYWxsb3dlZC1vcmlnaW5zIjpbIioiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImFwcHJvdmVyIiwiYXdhcmRlciIsIm9mZmxpbmVfYWNjZXNzIiwiYWRtaW4iLCJ1bWFfYXV0aG9yaXphdGlvbiIsImRlZmF1bHQtcm9sZXMtbmNwX3VhdCIsImJ1eWVyIiwiZXZhbHVhdG9yIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsibmNwdWF0Ijp7InJvbGVzIjpbImFwcHJvdmVyIiwiYmlkX2V2YWx1YXRvciIsInByb2Nlc3Nfc3VicHJvY2VzcyIsImJpZF9zdXJyb2dhdGVfYmlkZGVyIiwia3BpIiwiZ2xvYmFsX2NvbmZpZ3VyYXRpb24iLCJtYXN0ZXJzIiwiYWRtaW4iLCJiaWRfYXBwcm92ZXIiLCJidXllciIsInBtdF9zdGF0dXMiLCJhd2FyZGVyIiwiYmlkX29ic2VydmVyIiwic3VwZXJfYWRtaW4iLCJiaWRfYXdhcmRlciIsInByaWNlX3RlbXBsYXRlIiwiYmlkX3Byb2plY3Rfb3duZXIiLCJhcHByb3ZhbF9jcml0ZXJpYSIsImV2YWx1YXRvciJdfSwiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJvcGVuaWQgZW1haWwgcHJvZmlsZSIsInNpZCI6ImY1MjZjOTdhLTEwMzItNGVkMy1hNWI3LWRiYTY3YmJiNjU1NCIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJ1c2Vyc2NvcGUiOiJQUjpbYWxsXS1SRlFfQ1I6W2FsbF0tUkZRX0FQOlthbGxdLVJGUV9FVjpbYWxsXS1SRlFfQVc6W2FsbF0tTUFTOlthbGxdIiwicm9sZXMiOlsiYXBwcm92ZXIiLCJiaWRfZXZhbHVhdG9yIiwicHJvY2Vzc19zdWJwcm9jZXNzIiwiYmlkX3N1cnJvZ2F0ZV9iaWRkZXIiLCJrcGkiLCJnbG9iYWxfY29uZmlndXJhdGlvbiIsIm1hc3RlcnMiLCJhZG1pbiIsImJpZF9hcHByb3ZlciIsImJ1eWVyIiwicG10X3N0YXR1cyIsImF3YXJkZXIiLCJiaWRfb2JzZXJ2ZXIiLCJzdXBlcl9hZG1pbiIsImJpZF9hd2FyZGVyIiwicHJpY2VfdGVtcGxhdGUiLCJiaWRfcHJvamVjdF9vd25lciIsImFwcHJvdmFsX2NyaXRlcmlhIiwiZXZhbHVhdG9yIl0sImdyb3VwcyI6WyJhcHByb3ZlciIsImF3YXJkZXIiLCJvZmZsaW5lX2FjY2VzcyIsImFkbWluIiwidW1hX2F1dGhvcml6YXRpb24iLCJkZWZhdWx0LXJvbGVzLW5jcF91YXQiLCJidXllciIsImV2YWx1YXRvciJdLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJzYW5qZWV2a3VtYXIuY0BtaW5kc3ByaW50Lm9yZyIsIm1hdGVyaWFsY2F0ZWdvcnkiOiIxOls1IHQgNyw5LDExLDE1IHQgMTgsMjAgdCAyMywyNSwyNiwyOCw3MCw3Miw3NCw3NiB0IDc5LDgxLDg2IHQgOTMsOTUgdCAxMjYsMTI4IHQgMTM4LDE0NCB0IDE4OSwzNjMsNDAwLDQwMiB0IDQwNCw0MTAsNDE3LDQxOF0tMjpbMjkgdCA1NSw1NyB0IDYwLDE0MywzNDcsMzY0XS03Ols2MSB0IDY4LDEzOSB0IDE0MiwxOTMgdCAyMDEsMjA0IHQgMjMxLDIzMyB0IDI1MSwyNTMgdCAzNDYsMzY3XSIsImdpdmVuX25hbWUiOiJTYW5qZWV2IEt1bWFyIiwidXBuIjoic2FuamVldmt1bWFyLmNAbWluZHNwcmludC5vcmciLCJjb21wYW55Y29kZSI6IjEsMiw3IiwicGxhbnQiOiIxOlsxIHQgMTgsNTI3XS0yOlsxOSwyMCwyNl0tNzpbMjIgdCAyNV0iLCJuYW1lIjoiU2FuamVldiBLdW1hciBDIiwicHVyY2hhc2VvcmciOiIxOlsxIHQgMywxNF0tMjpbNCw1LDhdLTc6WzYsN10iLCJmYW1pbHlfbmFtZSI6IkMiLCJlbWFpbCI6InNhbmplZXZrdW1hci5jQG1pbmRzcHJpbnQub3JnIn0.fTwnKDYQ-mD1HXYJmN7xBvewKjqBQAbgk_9CccUUSzlo0dL7Gl2eD7AUb2u5lA7-2OCk8cMptU21tehpYW6OBg7f3NH9DG8EwppJ371ewW9oS4WnYukW2qLvrybCPiCapS_FHv_Ern8fogNDKTQQluoIhDRgQTrypATD62016jkygeGVMXxEwQMqEdA-sBHhAxCEFWvs1Hqbj2GQYv4U3j5lxsN9l0uctpGpT9LoXdmZ0jtsN_UCZy439Tg4yXVwbA-KROakAsXpR9HqIw-ylurToOPR7LE_A0CZBGAFCMKXabO2471CvWU7xAeMF4xuCnBZiPqmEY2JDxlX3RWYSA";            // Set request headers
			connection.setRequestProperty("authority", "ncpuat.olamagri.com");
			connection.setRequestProperty("accept", "text/plain");
			connection.setRequestProperty("accept-language", "en-GB,en-US;q=0.9,en;q=0.8");
			connection.setRequestProperty("authorization", bearer);
			connection.setRequestProperty("content-type", "application/json-patch+json");
			connection.setRequestProperty("origin", "https://ncpuat.olamagri.com");
			connection.setRequestProperty("referer", "https://ncpuat.olamagri.com/");
			connection.setRequestProperty("sec-ch-ua", "\"Not A(Brand\";v=\"99\", \"Google Chrome\";v=\"121\", \"Chromium\";v=\"121\"");
			connection.setRequestProperty("sec-ch-ua-mobile", "?0");
			connection.setRequestProperty("sec-ch-ua-platform", "\"Windows\"");
			connection.setRequestProperty("sec-fetch-dest", "empty");
			connection.setRequestProperty("sec-fetch-mode", "cors");
			connection.setRequestProperty("sec-fetch-site", "same-origin");
			connection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.0.0 Safari/537.36");
			connection.setDoOutput(true);

			String EventId = "1903";
			String  evaluationStartDate = "2024-02-16T17:00:00.67357+05:30";
			String  evaluationEndDate = "2024-02-16T17:00:00.67357+05:30";
			String  awardStartDate = "2024-02-16T17:00:00.67357+05:30";
			String  awardEndDate = "2024-02-16T17:00:00.67357+05:30";
			String  approvalStartDate="2024-02-16T17:00:00.67357+05:30";
			String  publishDate="2024-02-16T17:00:00.67357+05:30";
			String  approvalEndDate="2024-02-16T17:05:00.67357+05:30";
			String  EventStartDate="2024-02-16T17:00:00.67357+05:30";
			String  eventEnddate="2024-02-16T17:00:00.67357+05:30";



			String requestBody = "{\r\n"
					+ "    \"id\": " + EventId + ",\r\n"
					+ "    \"evaluationStartDate\": \"" + evaluationStartDate + "\",\r\n"
					+ "    \"evaluationEndDate\": \"" + evaluationEndDate + "\",\r\n"
					+ "    \"awardStartDate\": \"" + awardStartDate + "\",\r\n"
					+ "    \"awardEndDate\": \"" + awardEndDate + "\",\r\n"
					+ "    \"approvalStartDate\": \"" + approvalStartDate + "\",\r\n"
					+ "    \"approvalEndDate\": \"" + approvalEndDate + "\",\r\n"
					+ "    \"publishDate\": \"" + publishDate + "\",\r\n"
					+ "    \"eventStartDateTime\": \"" +  EventStartDate + "\",\r\n"
					+ "    \"eventEndDateTime\": \"" +  eventEnddate + "\",\r\n"
					+ "    \"isActive\": true,\r\n"
					+ "    \"isDeleted\": false,\r\n"
					+ "    \"createdBy\": 523,\r\n"
					+ "    \"updatedBy\": 523,\r\n"
					+ "    \"ownerId\": null,\r\n"
					+ "    \"biddingTypeId\": 1,\r\n"
					+ "    \"description\": \"Test\",\r\n"
					+ "    \"isTestProject\": false,\r\n"
					+ "    \"biddingLanguageId\": 1,\r\n"
					+ "    \"biddingRegionId\": null,\r\n"
					+ "    \"biddingBaseLineSpend\": 15080,\r\n"
					+ "    \"biddingTargetSavings\": 0,\r\n"
					+ "    \"allowUnApprovedVendors\": false,\r\n"
					+ "    \"canBidDuringPreview\": false,\r\n"
					+ "    \"previewTimeSpan\": 0,\r\n"
					+ "    \"duration\": 15,\r\n"
					+ "    \"responseStartDateTime\": \"0001-01-01T00:00:00+00:00\",\r\n"
					+ "    \"responseEndDateTime\": \"0001-01-01T00:00:00+00:00\",\r\n"
					+ "    \"biddingBeginAndEndTypeId\": null,\r\n"
					+ "    \"shouldTriggerOvertime\": false,\r\n"
					+ "    \"biddingBusinessUnitId\": null,\r\n"
					+ "    \"biddingCategoryId\": null,\r\n"
					+ "    \"biddingMaterialGroupOrTypeId\": null,\r\n"
					+ "    \"biddingCurrencyId\": 1,\r\n"
					+ "    \"name\": \"Test\",\r\n"
					+ "    \"eventStatusId\": 1,\r\n"
					+ "    \"purchaseRequestNos\": \"\",\r\n"
					+ "    \"purchaseRequestTypeId\": null,\r\n"
					+ "    \"businessUnits\": \"NG12 - Crown Floor Mill\",\r\n"
					+ "    \"materialCategories\": \"MRO/MRO Equipment & Supplies Fleet/VEHICLE LUBRICANTS/Lubricants1\",\r\n"
					+ "    \"countries\": \"Nigeria\",\r\n"
					+ "    \"isDirectBidding\": true,\r\n"
					+ "    \"isPrReferenceBidding\": null,\r\n"
					+ "    \"isRfqReferenceBidding\": null,\r\n"
					+ "    \"categoryLevel\": 1,\r\n"
					+ "    \"code\": \"E00001844\",\r\n"
					+ "    \"overtimeWithinPeriodInMinutes\": null,\r\n"
					+ "    \"overtimePeriodInMinutes\": null,\r\n"
					+ "    \"shouldShowBidRank\": true,\r\n"
					+ "    \"allowNonL1bidForPrice\": null,\r\n"
					+ "    \"allowGapFromL1priceToOther\": null,\r\n"
					+ "    \"biddingRulePercentage\": null,\r\n"
					+ "    \"submitTieBidL1typeId\": 1,\r\n"
					+ "    \"actionDate\": null,\r\n"
					+ "    \"paymentTermId\": null,\r\n"
					+ "    \"incoTermId\": null,\r\n"
					+ "    \"biddingTargetSavingsTypeId\": 1,\r\n"
					+ "    \"bidRanksToTriggerOverTime\": null,\r\n"
					+ "    \"leastCountPriceChangeTypeId\": 1,\r\n"
					+ "    \"priceDeviationLimit\": null,\r\n"
					+ "    \"priceDeviationTypeId\": 1\r\n"
					+ "}";

			try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
				wr.writeBytes(requestBody);
				wr.flush();
			}

			int responseCode = connection.getResponseCode();
			System.out.println("Response Code: " + responseCode);

			try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
				String inputLine;
				StringBuilder response = new StringBuilder();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}

				System.out.println("Response: " + response.toString());
			}
			connection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
