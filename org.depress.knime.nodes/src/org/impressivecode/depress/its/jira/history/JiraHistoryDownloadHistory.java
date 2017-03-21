package org.impressivecode.depress.its.jira.history;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.xml.bind.DatatypeConverter;

import org.apache.ws.commons.util.Base64;
import org.impressivecode.depress.its.common.ITSDataType;
import org.impressivecode.depress.its.jira.JiraOnlineAdapterParser;
import org.impressivecode.depress.its.jira.onlinemodel.JiraOnlineIssueChangeRowItem;
import org.impressivecode.depress.mg.usm.metricprocessor.UserStoryMetricProcessor;

public class JiraHistoryDownloadHistory {

	public Object downloadHistory(ITSDataType data) {
		String addres = prepareUrl(data);
		if (!addres.equals("ERROR")) {
			HttpURLConnection connection = createConnection(addres);
			if (connection != null) {
				String response = readResponse(connection);
				return this.convertJiraIssueHistoryToJsonList(JiraOnlineAdapterParser.parseSingleIssue(response));
			}
		}
		return new ArrayList<>();
	}
	
	private List<String> convertJiraIssueHistoryToJsonList(List<JiraOnlineIssueChangeRowItem> issues) {
		List<String> issuesJson = new ArrayList<>();
		for(JiraOnlineIssueChangeRowItem issue : issues) {
			issuesJson.add(issue.toString());
		}
		return issuesJson;
	}
	
	private String readResponse(HttpURLConnection connection) {
		try {
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			return response.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	private HttpURLConnection createConnection(String addres) {
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(addres).openConnection();
			// TODO[AKO]: set user login and password
			String userCredentials = "login:passwod";
			String basicAuth = "Basic " + DatatypeConverter.printBase64Binary(userCredentials.getBytes("UTF-8"));
			connection.setRequestProperty ("Authorization", basicAuth);
			return connection.getResponseCode() == 200 ? connection : null;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	private String prepareUrl(ITSDataType row) {
		if (row.getLink().length() > 1) {
			String baseUrl = row.getLink().split("browse")[0];
			return baseUrl + "rest/api/2/issue/" + row.getIssueId() + "?expand=changelog&fields=summary";
		} else {
			return "ERROR";
		}
	}

}
