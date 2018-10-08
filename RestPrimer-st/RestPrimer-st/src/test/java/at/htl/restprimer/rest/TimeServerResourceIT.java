package at.htl.restprimer.rest;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class TimeServerResourceIT {
    private Client client;
    private WebTarget tut;

    @Before
    public void initClient(){
        this.client = ClientBuilder.newClient();
        this.tut = this.client.target("http://localhost:8085/restprimer/rs/time");
    }

    @Test
    public void fetchTime(){
        Response response = this.tut.request(MediaType.TEXT_PLAIN).get();
        assertThat(response.getStatus(), is(200));
        String payload = response.readEntity(String.class);
        assertTrue(payload.startsWith("Time"));
    }

}
