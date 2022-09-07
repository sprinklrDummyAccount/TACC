class BackupThread extends Thread {
    public APIResponse update(Friend friend) throws Exception {
        APIResponse response = new APIResponse();
        connection = (HttpURLConnection) new URL(url + "/api/friend/update").openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("PUT");
        connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        connection.setUseCaches(false);
        connection.setConnectTimeout(TIMEOUT);
        connection.connect();
        marshaller.marshal(friend, new MappedXMLStreamWriter(new MappedNamespaceConvention(new Configuration()), new OutputStreamWriter(connection.getOutputStream(), "utf-8")));
        connection.getOutputStream().flush();
        connection.getOutputStream().close();
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            JSONObject obj = new JSONObject(new String(new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8")).readLine()));
            response.setDone(true);
            response.setMessage(unmarshaller.unmarshal(new MappedXMLStreamReader(obj, new MappedNamespaceConvention(new Configuration()))));
            connection.getInputStream().close();
        } else {
            response.setDone(false);
            response.setMessage("Update Friend Error Code: Http (" + connection.getResponseCode() + ")");
        }
        connection.disconnect();
        return response;
    }
}
