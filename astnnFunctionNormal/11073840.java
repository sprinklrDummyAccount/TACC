class BackupThread extends Thread {
    public Channel getChannel() {
        return CHANNEL_REF.getChannel();
    }
}
