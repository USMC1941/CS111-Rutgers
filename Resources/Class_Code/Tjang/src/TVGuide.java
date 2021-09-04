public class TVGuide {

    public static void main(String[] args) {
        int[] channels = {2, 4, 5, 7, 9, 11};
        String[] networks = {"CBS", "NBC", "FOX", "ABC", "My9", "CW"};

        System.out.println(channelLookUp(networks, channels, 11));
        System.out.println(networkLookUp(networks, "32"));
    }

    public static String networkLookUp(String[] networks, String net) {
        for (String s : networks) {
            if (net.equals(s)) {
                return s;
            }
        }
        return "network not found";
    }

    public static String channelLookUp(String[] networks, int[] channels, int channel) {
        for (int i = 0; i < channels.length; i++) {
            if (channel == channels[i]) {
                return networks[i];
            }
        }
        return "channel not found";
    }
}
